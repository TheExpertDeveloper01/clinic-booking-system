import { useNavigate } from "react-router-dom";
import { useAuth } from "../provider/authProvider";
import CoolNavbar from "../components/CoolNavbar";


const Home = () => {
    const { setToken } = useAuth();
    const naviagte = useNavigate();

    const handleHome = () => {
        setToken("this is a test token");
        naviagte("/", { replace: true });
    };

    setTimeout(() => {
        handleHome();

    }, 3 * 1000);

    return (
        <div> 
            
            <CoolNavbar/>
            </div>
    
    );
};

export default Home;