import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { useAuth } from "../provider/authProvider";
import { ProtectedRoute } from "./ProtectedRoute";

const Routes = () => {
    const { token } = useAuth();
    // Route configurations

    const routesForPublic = [
        {
            path: "/",
            element: <div>Home Page</div>
        },
        {
            path: "/register",
            element: <div>Register</div>
        },
    ];

    const routesForAuthenticatedOnly = [
        {
            path: "/",
            element: <ProtectedRoute />,
            children: [
                {
                    path:"/profile",
                    element: <div>Profile</div>
                },
                {
                    path: "/logout",
                    element: <div>Log out</div>
                },
            ],
        },
    ];

    const routesForNotAuthenticatedOnly = [
        {
            path: "/",
            element: <div>Home Page</div>,
        },
        {
            path: "/login",
            element: <div>Login</div>,
        },

    ];

    // Combine and conditionally include routes based on authentication status
    const router = createBrowserRouter([
        ...routesForPublic,
        ...ProtectedRoute(!token ? routesForNotAuthenticatedOnly : []),
        ...routesForAuthenticatedOnly,
    ]);

    // Provide the router configuration using RouterProvider
    return <RouterProvider router={router} />;

};

export default Routes;