package kr.soft.study.api;

import jakarta.servlet.http.HttpServletRequest;
import kr.soft.study.dto.BoardDTO;
import kr.soft.study.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberController {

    @GetMapping("/")
    public void print(){
        System.out.println("first");

        log.info("qwer");

        MemberDTO member = new MemberDTO();
        member.setUserId("qwer");
        member.getUserId();
        member.toString();

        BoardDTO board = new BoardDTO(5,"title","content");
        BoardDTO board1 = BoardDTO
                .builder()
                .idx(5)
                .title("제목1")
                .content("내용1")
                .build();

        log.info("data: {}",board1.toString());
    }

    @GetMapping("/data")
    public String data(){
        return "Hello World";
    }

    @GetMapping("/member")
    public MemberDTO member(){
        MemberDTO member = new MemberDTO();

        member.setUserId("superman");
        member.setUserPw("1234");

        return member;
    }

    @GetMapping("/idCheck")
    public MemberDTO idCheck(HttpServletRequest request){
        String id = request.getParameter("userId");
        //DB

        MemberDTO member = new MemberDTO();
        member.setUserId(id);

        return  member;
    }

    @PostMapping("/join")
    public MemberDTO join(@RequestBody MemberDTO member){
        log.info(member.toString());

        return member;
    }
}
