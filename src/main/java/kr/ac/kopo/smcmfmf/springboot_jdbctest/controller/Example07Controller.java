package kr.ac.kopo.smcmfmf.springboot_jdbctest.controller;

import kr.ac.kopo.smcmfmf.springboot_jdbctest.domain.Player;
import kr.ac.kopo.smcmfmf.springboot_jdbctest.domain.Team;
import kr.ac.kopo.smcmfmf.springboot_jdbctest.repository.PlayerRepository;
import kr.ac.kopo.smcmfmf.springboot_jdbctest.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam07")
public class Example07Controller {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public String requestInsert(Model model) {
        Team team = new Team();
        team.setName("team01");
        teamRepository.save(team);

        Player player = new Player();
        player.setName("김폴리");
        player.setTeam(team);
        playerRepository.save(player);

        List<Player> playerList = playerRepository.findAll();
        List<Team> teamList = teamRepository.findAll();

        model.addAttribute("players", playerList);
        model.addAttribute("teams", teamList);

        return "/viewPage07";
    }
}
