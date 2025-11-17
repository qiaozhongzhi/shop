package org.wendu.dye.security.api;


import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wendu.dye.common.CurrentUser;
import org.wendu.dye.common.DyeConstants;
import org.wendu.dye.common.Result;
import org.wendu.dye.common.TokenUtils;
import org.wendu.dye.security.dto.PasswordDto;
import org.wendu.dye.security.service.PasswordService;

@Slf4j
@RestController
@RequestMapping("/password")
public class PasswordApi {

    @Autowired
    private PasswordService passwordService;

    @PutMapping("")
    public Result passwordDoUpdate(@RequestBody PasswordDto dto,
                                   @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        dto.setCurrentUserId(currentUser.getUserId());
        passwordService.updatePassword(dto);
        return Result.OK();
    }

}
