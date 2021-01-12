package com.vimal.app.controller;

import com.vimal.app.entity.TwilioCallBackResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController()
@RequestMapping("/callback")
@Slf4j
public class CallbackRestController {

    @GetMapping("/ping")
    public String acknowledge(){
      log.info("Calling ping Service");
      return "I am Alive";
    }
    @PostMapping(value = "status/", produces = "text/xml")
    public String getTwilioSMSCallbackStatus(HttpServletRequest request,
                                             @RequestParam(value = "MessageStatus", required = false) String messageStatus,
                                             @RequestParam(value = "ApiVersion", required = false) String apiVersion,
                                             @RequestParam(value = "SmsSid", required = false) String smsSid,
                                             @RequestParam(value = "SmsStatus", required = false) String smsStatus,
                                             @RequestParam(value = "To", required = false) String to,
                                             @RequestParam(value = "From", required = false) String from,
                                             @RequestParam(value = "MessageSid", required = false) String messageSid,
                                             @RequestParam(value = "AccountSid", required = false) String accountSid){
        log.info("Inside Class {} @method getTwilioSMSCallbackStatus ",this.getClass().getName());
        //Getting ALl the Patameters in Servlet Request
        Enumeration<String> enumeration = request.getParameterNames();
        while(enumeration.hasMoreElements()){
            String parameterName = enumeration.nextElement();
            log.info("Received Parameter {} -> value {} ",parameterName,request.getParameter(parameterName));
        }
        // prepare Entity Class TwilioCallBackResponse
       TwilioCallBackResponse twilioCallBackResponse = TwilioCallBackResponse.builder().messageSid(messageSid)
                .accountSid(accountSid)
                .apiVersion(apiVersion)
                .from(from)
                .to(to)
                .smsStatus(smsStatus)
                .smsSid(smsSid)
                .messageStatus(messageStatus).build();
        log.info("TwilioCallBackResponse {} ",twilioCallBackResponse);
        return "<Response/>";
    }

}
