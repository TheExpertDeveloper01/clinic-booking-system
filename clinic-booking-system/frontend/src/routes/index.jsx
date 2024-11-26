import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { useAuth } from "../provider/authProvider";
import { ProtectedRoute } from "./ProtectedRoute";


const Routes = () => {
    const { token } = useAuth();

    // Define public routes accessible to all users
    const routesForPublic = [
        {
            path: "/service",
            element: <div>Service Page</div>,
        },
        {
            path: "/about-shafi",
            element: <div>About Shafi</div>,
        },
    ];

    // Define routes accessible only to authenticated users
    const routesForAuthenticatedOnly = [
        {
            path: "/",
            element: <ProtectedRoute />, // Wrap the component in the ProtectedRoute
            children: [
                {
                    path: "/profile",
                    element: <div> User Profile</div>,
                },
            ],
        },
    ];

    // Define routes for accessible only to non-authenticated users
    const routesForNotAuthenticatedOnly = [
        {
            path: "/login",
            element: <div>Login Page</div>,
        },
    ];

    // Combine and conditionally include routes based on authentication status
    const router = createBrowserRouter([
        ...routesForPublic,
        ...(!token ? routesForNotAuthenticatedOnly : []),
        ...routesForAuthenticatedOnly,

    ]);

    // Provide the router configuration using RouterProvider
    return <RouterProvider router={router} />;

};

export default Routes;