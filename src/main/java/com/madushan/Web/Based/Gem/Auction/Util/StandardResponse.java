package com.madushan.Web.Based.Gem.Auction.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse {

    public int code;
    private String message;
    private Object data;
}
