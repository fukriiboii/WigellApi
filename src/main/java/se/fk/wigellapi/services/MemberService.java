package se.fk.wigellapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.fk.wigellapi.exceptions.ResourceNotFoundException;
import se.fk.wigellapi.models.Member;
import se.fk.wigellapi.repositories.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements MemberServiceInterface{

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long id) {
        if (memberRepository.existsById(id)){
            Optional<Member> existingMember =  memberRepository.findById(id);

            if (existingMember.isPresent()) {
                return existingMember.get();
            }
        }
            throw new ResourceNotFoundException("Member", "id", id);
    }

    @Override
    public Member addNewMember(Member member) {
        return memberRepository.save(member);
        /*Address address = member.getAddress();
        if (address != null && address.getStreet() != null && address.getCity() != null){
            Address existingAdress = addressRepository.findByStreetAndCityAndPostalCode(
                    address.getStreet(),
                    address.getCity(),
                    address.getPostalCode());
            if (existingAdress == null){
                existingAdress = addressRepository.save(address);
            }
            member.setAddress(existingAdress);
        }
        return memberRepository.save(member);*/
    }

    @Override
    public Member updateMember(Long id, Member member) {
        Member existingMember = memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Member", "id", id));
        existingMember.setFirstName(member.getFirstName());
        existingMember.setLastName(member.getLastName());
        existingMember.setAddress(member.getAddress());
        existingMember.setEmail(member.getEmail());
        existingMember.setPhoneNumber(member.getPhoneNumber());
        existingMember.setDateOfBirth(member.getDateOfBirth());
        memberRepository.save(existingMember);
        return existingMember;
    }
    @Override
    public void deleteMember(Long id) {
        memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Member", "id", id));
        memberRepository.deleteById(id);
    }
}
