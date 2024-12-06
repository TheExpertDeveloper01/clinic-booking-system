import { useNavigate } from "react-router-dom";
import { useAuth } from "../provider/authProvider";


const Register = () => {
    const { setToken } = useAuth();
    const naviagte = useNavigate();

    const handleRegister = () => {
        setToken("this is a test token");
        naviagte("/", { replace: true });
    };

    setTimeout(() => {
        handleRegister();

    }, 3 * 1000);

    return <div>Register</div>;
};

export default Register;