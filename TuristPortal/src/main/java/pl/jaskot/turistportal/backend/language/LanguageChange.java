package pl.jaskot.turistportal.backend.language;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.tabs.Tab;

public class LanguageChange {

    public static Tab setTabName(Tab tab, int i, String language){
        if(i==1){
            tab.removeAll();
            tab.add(new Icon(VaadinIcon.DIAMOND));
            if(language=="Polski"){
                tab.add("Witamy");
            }
            else if(language=="English"){
                tab.add("Welcome");
            }
            else if(language=="Français"){
                tab.add("Salut");
            }
            else if(language=="Italiano"){
                tab.add("Benvenuto");
            }
            else if(language=="Deutsch"){
                tab.add("Willkommen");
            }
            else if(language=="Türk"){
                tab.add("Merhaba");
            }
            return tab;
        }
        else if(i==2){
            tab.removeAll();
            tab.add(new Icon(VaadinIcon.SUITCASE));
            if(language=="Polski"){
                tab.add("Oferta");
            }
            else if(language=="English"){
                tab.add("Offer");
            }
            else if(language=="Français"){
                tab.add("Offre");
            }
            else if(language=="Italiano"){
                tab.add("Offerta");
            }
            else if(language=="Deutsch"){
                tab.add("Offerte");
            }
            else if(language=="Türk"){
                tab.add("Teklif");
            }
            return tab;
        }
        else if(i==3){
            tab.removeAll();
            tab.add(new Icon(VaadinIcon.USER_STAR));
            if(language=="Polski"){
                tab.add("Asystent");
            }
            else if(language=="English"){
                tab.add("Assistant");
            }
            else if(language=="Français"){
                tab.add("Assistant");
            }
            else if(language=="Italiano"){
                tab.add("Assistente");
            }
            else if(language=="Deutsch"){
                tab.add("Assistent");
            }
            else if(language=="Türk"){
                tab.add("Asistan");
            }
            return tab;
        }
        else if(i==4){
            tab.removeAll();
            tab.add(new Icon(VaadinIcon.USER_CARD));
            if(language=="Polski"){
                tab.add("Autorzy");
            }
            else if(language=="English"){
                tab.add("Authors");
            }
            else if(language=="Français"){
                tab.add("Auteurs");
            }
            else if(language=="Italiano"){
                tab.add("Autori");
            }
            else if(language=="Deutsch"){
                tab.add("Autoren");
            }
            else if(language=="Türk"){
                tab.add("Yazarlar");
            }
            return tab;
        }
        else {
            return null;
        }
    }

    public static Select setSelectLang(Select select, String language){
        if(language=="Polski"){
            select.setLabel("Język");
        }
        else if(language=="English"){
            select.setLabel("Language");
        }
        else if(language=="Français"){
            select.setLabel("Langue");
        }
        else if(language=="Italiano"){
            select.setLabel("Lingua");
        }
        else if(language=="Deutsch"){
            select.setLabel("Sprache");
        }
        else if(language=="Türk"){
            select.setLabel("Dil");
        }
        return select;
    }

    public static void showLangInfo(String language){
        Notification notification = new Notification();
        notification.setDuration(3000);
        if(language=="Polski"){
            notification.setText("Język zmieniono na polski");
        }
        else if(language=="English"){
            notification.setText("The language has been changed to English");
        }
        else if(language=="Français"){
            notification.setText("La langue a été changée en français");
        }
        else if(language=="Italiano"){
            notification.setText("La lingua è stata cambiata in italiano");
        }
        else if(language=="Deutsch"){
            notification.setText("La lingua è stata cambiata in tedesco");
        }
        else if(language=="Türk"){
            notification.setText("Dil türkçeye değiştirildi");
        }
        notification.setPosition(Notification.Position.BOTTOM_CENTER);
        notification.open();
    }
}
