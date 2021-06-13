package espminvest.poo.cambio.common.controller;

import espminvest.poo.cambio.common.datatype.CurrencyBean;
import espminvest.poo.cambio.common.datatype.EstimateBean;
import org.bouncycastle.jcajce.provider.symmetric.ARC4;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static espminvest.poo.cambio.common.constants.Constants.BASE_URL;

import java.util.List;

@FeignClient("service.cambio")
public interface CambioController {

    @GetMapping(BASE_URL + "/currencies")
    List<CurrencyBean> listCurrencies();

    @GetMapping(BASE_URL + "/currencies/{currencyId}")
    CurrencyBean getCurrency(@PathVariable String currencyId);

    @GetMapping(BASE_URL + "/{currencyId}/{date}")
    EstimateBean getEstimate(@PathVariable String currencyId, @PathVariable String date);

    @GetMapping(BASE_URL + "/")
    List<EstimateBean> getEstimates(String currencyId, String dateInit, String dateEnd);

}
