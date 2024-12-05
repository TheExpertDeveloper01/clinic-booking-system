import { useNavigate } from "react-router-dom";
import { useAuth } from "../provider/authProvider";


const Login = () => {
    const { setToken } = useAuth();
    const naviagte = useNavigate();

    const handleLogin = () => {
        setToken("this is a test token");
        naviagte("/", { replace: true });
    };

    setTimeout(() => {
        handleLogin();

    }, 3 * 1000);

    return <>Login Page</>;
};

export default Login;