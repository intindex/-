package waimai.itf;

import java.util.List;

import waimai.model.Beandingdan;
import waimai.util.BaseException;

public interface IdingdanManger {
       public List<Beandingdan> loadall() throws BaseException;
}
