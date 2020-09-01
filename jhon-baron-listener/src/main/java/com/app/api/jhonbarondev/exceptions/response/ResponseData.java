package com.app.api.jhonbarondev.exceptions.response;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseData implements Serializable {
  private String id;
  private String message;
}
