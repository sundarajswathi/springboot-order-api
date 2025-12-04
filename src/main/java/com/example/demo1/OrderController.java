package com.example.demo1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/formdata")
public class OrderController {
    @Autowired
    private OrderRepository form;
 @PostMapping
    public OrderDataModel SubmitFormDataModel(@RequestBody OrderDataModel Data){
        return form.save(Data);

    }
   @GetMapping
    public List<OrderDataModel> getAllForms(){//multiple values store pani irukum db la athunala than namba
        //list use panurom ethu multiple values return pani orey method name la namku send  panum getallforms()--->ethu method name
        //method name illama method declare pana mudiyathu apram complie time error varum 
        return form.findAll();
    }
   @GetMapping("/{id}")
    public Optional<OrderDataModel>getFormDataById(@PathVariable String id){
        return form.findById(id);
    }

    
    
    @PutMapping("/{id}")
public OrderDataModel updateSingleField(@PathVariable String id, @RequestBody OrderDataModel updateData){
    return form.findById(id).map(existingData ->{
        
        if(updateData.getName()!=null){
            existingData.setName(updateData.getName());
        }
        if(updateData.getDistrict()!=null){
            existingData.setDistrict(updateData.getDistrict());
        }
        if(updateData.getAddress()!=null){
            existingData.setAddress(updateData.getAddress());
        }
        if(updateData.getPno() != null)
{
            existingData.setPno(updateData.getPno());
        }
        if(updateData.getStreet()!=null){
            existingData.setStreet(updateData.getStreet());
        }

        return form.save(existingData);
    })
    .orElseThrow(() -> new RuntimeException("Data not found with id: " + id));
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteFormData(@PathVariable String id){
    form.deleteById(id);
    return ResponseEntity.ok("form data successfully delete with ID: "+ id);
}

@DeleteMapping
public ResponseEntity<String> deleteFormAllData(){
    form.deleteAll();
    return ResponseEntity.ok("delete all");
}
}
     

