package kr.ac.kopo.smcmfmf.springboot_jdbctest.controller;

import kr.ac.kopo.smcmfmf.springboot_jdbctest.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam01")
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public String requestMethod(Model model) {
        String sql = "select * from person"; // 테이블 내용 불러오기
        List<Person> personList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person.class));
        model.addAttribute("personList", personList);
        return "viewPage01";
    }

    @GetMapping("/new")
    public String newMethod(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "viewPage01_new";
    }

    @PostMapping("/insert")
    public String insertMethod(@ModelAttribute Person person) {
        String sql = "insert into person(name, age, email) values(?,?,?)";
//        jdbcTemplate.update(sql, person.getName(), person.getAge(), person.getEmail());
        Object[] params = {person.getName(), person.getAge(), person.getEmail()}; // 오브젝트 배열로 저장 후 사용
        int resultCount = jdbcTemplate.update(sql, params); // 업데이트 한 개수를 반환함
        return "redirect:/exam01";
    }
}
