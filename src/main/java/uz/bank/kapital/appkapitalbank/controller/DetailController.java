package uz.bank.kapital.appkapitalbank.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.DetailDto;
import uz.bank.kapital.appkapitalbank.service.DetailImplService;

import java.util.Set;

@RestController
@RequestMapping("/api/detail")
public class DetailController {

    final DetailImplService detailImplService;

    public DetailController(DetailImplService detailImplService) {
        this.detailImplService = detailImplService;
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody Set<DetailDto> detailDto) {

        ApiResponse apiResponse = detailImplService.add(detailDto);
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);
    }
}



