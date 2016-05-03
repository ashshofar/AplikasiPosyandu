package id.posyandu.controller;

import id.posyandu.domain.Jabatan;
import id.posyandu.domain.User;
import id.posyandu.service.JabatanService;
import id.posyandu.service.UserService;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@ComponentScan
public class UserController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    JabatanService jabatanService;
    
    @RequestMapping(value = {"/user", "/user/savepage"}, method = RequestMethod.GET)
    public String savePage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allUsers", (ArrayList<User>) userService.getAllUsers());
        model.addAttribute("allJabatans", (Collection<Jabatan>) jabatanService.getAllJabatans());
        return "/user/index";
    }
    
    @RequestMapping(value = {"/user/save"}, method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user,
            final RedirectAttributes redirectAttributes) {

        if (userService.saveUser(user) != null) {
            redirectAttributes.addFlashAttribute("saveUser", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveUser", "unsuccess");
        }

        return "redirect:/user/savepage";
    }
    
    @RequestMapping(value = "/user/{operation}/{userId}", method = RequestMethod.GET)
    public String editRemoveUser(@PathVariable("operation") String operation,
            @PathVariable("userId") String userId, final RedirectAttributes redirectAttributes,
            Model model) {
        if (operation.equals("delete")) {
            if (userService.deleteUser(userId)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            User editUser = userService.findUser(userId);
            if (editUser != null) {
                model.addAttribute("editUser", editUser);
                return "editPage";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }

        return "redirect:/user/savepage";
    }
    
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("editUser") User editUser,
            final RedirectAttributes redirectAttributes) {
        if (userService.editUser(editUser) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/user/savepage";
    }
}
