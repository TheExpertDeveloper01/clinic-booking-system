import { Navigate, Outlet } from "react-router-dom";
import { useAuth } from "../provider/authProvider";

const ProtectedRoute = () => {
    const { token } = useAuth();

    // If the user is not authenticated, redirect to login page
    if (!token) {
        return <Navigate to="/login" />;
    }

    // If authenticated, render child routes
    return <Outlet />;
};

export default ProtectedRoute;