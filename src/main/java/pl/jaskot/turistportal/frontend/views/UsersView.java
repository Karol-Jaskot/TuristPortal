package pl.jaskot.turistportal.frontend.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.jaskot.turistportal.backend.entity.User;
import pl.jaskot.turistportal.backend.repo.UserRepo;

import java.time.LocalDate;
import java.util.List;

import static pl.jaskot.turistportal.frontend.logic.configs.BasicLayoutConfigurations.setBasicConfigForLayout;

public class UsersView extends VerticalLayout {

    private Logger logger = LoggerFactory.getLogger(UsersView.class);
    private List<User> itemMasterList;
    private Grid<User> grid;
    private Button btnRefresh, btCreateUser;
    private UserRepo userRepo;

    private TextField tfFirstName, tfLastName;


    public UsersView(UserRepo userRepo){
        this.userRepo = userRepo;
        setBasicConfigForLayout(this, "users-view");

        btnRefresh = new Button("Refresh");
        btnRefresh.addClickListener(e->refreshView());

        grid = new Grid<>(User.class);
        grid.setHeightByRows(true);
        grid.removeAllColumns();
        grid.addColumn(User::getId).setSortable(true).setHeader("Identyfikator");
        grid.addColumn(User::getFirst_name).setHeader("Imię");
        grid.addColumn(User::getLast_name).setSortable(true).setHeader("Nazwisko");
        grid.addColumn(User::getCreate_date).setHeader("Data dodania");
        grid.setMultiSort(true);

        btCreateUser = new Button("Dodaj użytkownika");
        btCreateUser.addClickListener(e->createUser());
        btCreateUser.addClickShortcut(Key.ENTER);

        tfFirstName = new TextField("Imię:");
        tfFirstName.setPlaceholder("Najlepiej prawdziwe");
        tfLastName = new TextField("Nazwisko:");

        HorizontalLayout userLayout = new HorizontalLayout();
        userLayout.add(tfFirstName, tfLastName,btCreateUser);

        add(userLayout, grid);
        refreshView();
    }

    public void createUser(){
        userRepo.save(User.builder()
                .first_name(tfFirstName.getValue())
                .last_name(tfLastName.getValue())
                .create_date(LocalDate.now())
                .build()
        );
        refreshView();
    }

    public void refreshView(){
        itemMasterList = (List<User>) userRepo.findAll();
        grid.setItems(itemMasterList);
    }

}
