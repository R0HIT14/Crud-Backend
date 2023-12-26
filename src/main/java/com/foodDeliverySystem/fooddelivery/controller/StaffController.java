package com.foodDeliverySystem.fooddelivery.controller;

import com.foodDeliverySystem.fooddelivery.modal.Staff;
import com.foodDeliverySystem.fooddelivery.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin("http://localhost:5173")
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;

    @PostMapping("/staff")
    Staff newStaff(@RequestBody Staff newStaff){
        return staffRepository.save(newStaff);
    }

    @GetMapping("/staffs")
    List<Staff> getAllStaffs(){
        return staffRepository.findAll();
    }

    @GetMapping("/staff/{id}")
    Staff getStaffById(@PathVariable Long id){
        return staffRepository.findById(id).orElseThrow(()->new NoSuchElementException(String.valueOf(id)));
    }

    @PutMapping("staff/{id}")
    Staff updateStaff(@RequestBody Staff newStaff, @PathVariable Long id){
        return staffRepository.findById(id)
                .map(staff->{
                    staff.setName(newStaff.getName());
                    staff.setContactNumber((newStaff.getContactNumber()));
                    staff.setDayOfOperations(newStaff.getDayOfOperations());
                    return staffRepository.save(staff);
                }).orElseThrow(()-> new NoSuchElementException(String.valueOf(id)));
    }

    @DeleteMapping("staff/{id}")
    String deleteStaff(@PathVariable Long id){
        if(!staffRepository.existsById((id))){
            throw new NoSuchElementException();
        }
        staffRepository.deleteById((id));
        return "Staff with id : "+id+" has been deleted";
    }

}
