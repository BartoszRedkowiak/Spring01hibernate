package pl.coderslab;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface ControllerInterface <T> {

    public String list(Model model);

    public String add(Model model);

    public String add(T t, BindingResult result);

    public String delete(long id);

    public String update(long id, Model model);

    public String update(T t, BindingResult result);

}
