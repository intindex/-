package waimai.itf;

import java.util.List;

import waimai.model.Beanyonghuyouhui;
import waimai.util.BaseException;

public interface IyonghuyouhuiManger {
       public List<Beanyonghuyouhui> loadall()throws BaseException;
}
