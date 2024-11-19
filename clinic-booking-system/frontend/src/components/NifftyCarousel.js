import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

import C_Image1 from '../images/C_Image1.jpg';
import C_Image2 from '../images/C_Image2.jpg';
import C_Image3 from '../images/C_Image3.jpg';

function NifftyCarousel(){
    return(

        <div id="carouselExampleIndicators" className="carousel slide carousel-fade" data-ride="carousel" data-interval="3000">
            <ol className="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" className="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div className="carousel-inner">
                <div className="carousel-item active">
                    <img className="d-block w-100" src={C_Image1} alt="First slide" />
                </div>
                <div className="carousel-item">
                    <img className="d-block w-100" src={C_Image2} alt="Second slide" />
                </div>
                <div className="carousel-item">
                    <img className="d-block w-100" src={C_Image3} alt="Third slide" />
                </div>
            </div>
            <a className="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                <span className="sr-only">Previous</span>
            </a>
            <a className="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span className="carousel-control-next-icon" aria-hidden="true"></span>
                <span className="sr-only">Next</span>
            </a>
        </div>

    );
}

export default NifftyCarousel;