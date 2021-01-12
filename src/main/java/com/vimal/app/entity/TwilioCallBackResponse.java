package com.vimal.app.entity;

import lombok.*;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TwilioCallBackResponse {
   private String messageStatus;
   private String apiVersion;
   private String smsSid;
   private String smsStatus;
   private String to;
   private String from;
   private  String messageSid;
   private String accountSid;
}
