import React, { useEffect, useState } from "react";
import axios from "axios";

const IncidentDashboard = () => {
    const [incidents, setIncidents] = useState([]);
    const [loading, setLoading] = useState(true);
    const [issueDescription, setIssueDescription] = useState("");
    const [prediction, setPrediction] = useState("");
    const [error, setError] = useState("");
    const [loadingPrediction, setLoadingPrediction] = useState(false);

    // Fetch previous incidents from the backend
    useEffect(() => {
        axios.get("http://localhost:8080/api/incidents") // ✅ Updated API endpoint
            .then(response => {
                setIncidents(response.data);
                setLoading(false);
            })
            .catch(error => {
                console.error("Error fetching incidents:", error);
                setLoading(false);
            });
    }, []);

    // Function to get AI recommendations for a new incident
    const handlePredict = async () => {
        if (!issueDescription.trim()) {
            setError("Please enter an issue description.");
            return;
        }

        setLoadingPrediction(true);
        setError("");
        setPrediction(""); // Clear previous prediction

        try {
            const response = await axios.get(`http://localhost:8080/api/incidents/predict?issue=${encodeURIComponent(issueDescription)}`);

            // ✅ Fix: Extract recommendation properly
            const recommendation = typeof response.data === "string" ? response.data : "No recommendation available.";

            setPrediction(recommendation);
        } catch (err) {
            console.error("Error fetching prediction:", err);
            setError("Failed to fetch AI recommendation. Please try again.");
        } finally {
            setLoadingPrediction(false);
        }
    };

    if (loading) {
        return <h2>Loading...</h2>;
    }

    return (
        <div style={{ padding: "20px", maxWidth: "800px", margin: "auto" }}>
            <h1>Incident Dashboard</h1>

            {/* Table displaying previous incidents */}
            <table border="1" style={{ width: "100%", marginBottom: "20px" }}>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Description</th>
                        <th>Type</th>
                        <th>Resolved</th>
                        <th>Resolution</th>
                    </tr>
                </thead>
                <tbody>
                    {incidents.map((incident) => (
                        <tr key={incident.id}>
                            <td>{incident.id}</td>
                            <td>{incident.issueDescription}</td>
                            <td>{incident.issueType}</td>
                            <td>{incident.resolved ? "✅ Yes" : "❌ No"}</td>
                            <td>{incident.resolution || "Pending"}</td>
                        </tr>
                    ))}
                </tbody>
            </table>

            {/* AI Prediction Section */}
            <h2>Get AI Recommendation</h2>
            <textarea
                value={issueDescription}
                onChange={(e) => setIssueDescription(e.target.value)}
                placeholder="Enter new issue description..."
                rows="4"
                style={{ width: "100%", padding: "10px", marginBottom: "10px" }}
            />
            <button onClick={handlePredict} disabled={loadingPrediction} style={{ padding: "10px 15px", cursor: "pointer" }}>
                {loadingPrediction ? "Predicting..." : "Get Recommendation"}
            </button>

            {error && <p style={{ color: "red" }}>{error}</p>}

            {prediction && (
                <div style={{ marginTop: "20px", padding: "15px", background: "#e0f7fa", borderLeft: "5px solid #00796b" }}>
                    <h3>AI Suggested Resolution:</h3>
                    <p>{prediction}</p>
                </div>
            )}
        </div>
    );
};

export default IncidentDashboard;
