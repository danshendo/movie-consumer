package cc.itcast.cn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User findOne = this.userRepository.findOne(id);
        return findOne;
    }
    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        this.userRepository.delete(id);
    }
    @GetMapping("/findAll")
    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    @GetMapping("/addUser")
    public User addUser(){
        User user = new User();
        Long id = Long.parseLong("5");
        user.setId(id);
        user.setAge(43);
        user.setBalance(new BigDecimal(129.09));
        user.setName("张昌琳");
        user.setUsername("acount5");
        return this.userRepository.save(user);
    }

    @GetMapping("/update")
    public User update(){
        Long id = Long.parseLong("5");
        String name = "玩的九年";
        User user = new User();
        user.setName(name);
        user.setId(id);
        return  this.userRepository.saveAndFlush(user);
    }
}
