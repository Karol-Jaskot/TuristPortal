package pl.jaskot.turistportal.frontend.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AuthorView extends VerticalLayout {

    public AuthorView() {
        getStyle().set("backgroundColor", "white");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Image imgJaskot = new Image("https://www.traktorpool.pl/media/hhp/Jaskot_Grzegorz_101164.jpg?force=1&text=","Foto");
        imgJaskot.setMaxHeight("300px");
        imgJaskot.setMaxWidth("600px");
        imgJaskot.setWidthFull();
        imgJaskot.setHeightFull();

        Image imgBury = new Image("https://thfcomms.com.au/wp-content/uploads/2018/02/Bury-Logo_biggest-new.jpg","Foto");
        imgBury.setMaxHeight("400px");
        imgBury.setMaxWidth("600px");
        imgBury.setHeightFull();
        imgBury.setWidthFull();
        add(imgBury, imgJaskot);
    }
}
