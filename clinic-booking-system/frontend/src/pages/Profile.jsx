import { useNavigate } from "react-router-dom";
import { useAuth } from "../provider/authProvider";


const Profile = () => {
    const { setToken } = useAuth();
    const naviagte = useNavigate();

    const handleProfile = () => {
        setToken("this is a test token");
        naviagte("/", { replace: true });
    };

    setTimeout(() => {
        handleProfile();

    }, 3 * 1000);

    return <>Profile Page</>;
};

export default Profile;