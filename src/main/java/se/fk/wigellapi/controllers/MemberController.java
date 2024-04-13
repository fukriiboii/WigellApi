package se.fk.wigellapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.fk.wigellapi.models.Member;
import se.fk.wigellapi.services.MemberService;

import java.util.List;

//FIXA ADDMEMBER SÅ ATT ADRESSEN INTE BLIR NULL!
//FIXA EXCEPTIONS
// OM DU HINNER THYMELEAF
//Är det nån metod som ska ha JSON svar, sätt @Responsbody för den metoden.
@Controller
@RequestMapping("/admin")

public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMembers(){
        List<Member> members = memberService.getAllMembers();
        System.out.println("Number of members fetched: " + members.size());
        return ResponseEntity.ok().body(members);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable ("id") Long id){
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PutMapping("/updatemember/{id}") //TODO
    public ResponseEntity<Member> updateMemberById(@PathVariable ("id") Long id, @RequestBody Member member){
        return ResponseEntity.ok(memberService.updateMember(id, member));
    }

    @PostMapping("/addmember/") //TODO create custom exception
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.addNewMember(member), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletemember/{id}") //TODO
    public ResponseEntity<String> deleteMemberById(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>("Member deleted", HttpStatus.OK);
    }
}
