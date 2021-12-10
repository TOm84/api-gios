package akademia.controller;

import akademia.services.AirService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
  private final AirService airService;

  public HomeController(AirService airService) {
    this.airService = airService;
  }

  @GetMapping("/")
  public String getHomePage(Model model) {
//    model.addAttribute("hashList", airService.stationName());
//    model.addAttribute("bycity", airService.stationByCity("warszawa"));
    model.addAttribute("byprovince", airService.stationByProvince("wielkopolskie"));
    return "index";
  }

  @GetMapping("allstation")
  public String allStationPage (
      @RequestParam(value = "city", required = false) String city,
      @RequestParam(value = "province", required = false) String province,
      Model model) {
    if (city!=null) {
      model.addAttribute("allstat", airService.stationByCity(city));
    } else if (province!=null) {
      model.addAttribute("allstat", airService.stationByProvince(province));
    } else {
      model.addAttribute("allstat", airService.allStation());
    }
    return "allstation";
  }

  @GetMapping("airquality")
  public String airQualityPage (
      @RequestParam(value = "idstat", required = false) Integer id,
      @RequestParam(value = "list", required = false) Integer idList,
      Model model) {
    if (id!=null) {
      model.addAttribute("takestation", airService.qualityModels(id));
    }
    if (idList!=null) {
      model.addAttribute("takestation", airService.qualityModels(idList));
    }
    model.addAttribute("stationNameList", airService.stationName());
    return "airquality";
  }
}
