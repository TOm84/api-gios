package akademia.controller;

import akademia.model.QualityModel;
import akademia.model.StationModel;
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
//    model.addAttribute("allstation", airService.allStation());
//
//    model.addAttribute("test", airService.qualityModels(837));

    model.addAttribute("hashList", airService.stationName());
    return "index";
  }

  @GetMapping("allstation")
  public String allStationPage (
      @RequestParam(value = "idStation", required = false) Integer id,
      Model model) {
    model.addAttribute("allstat", airService.allStation());
    if (id!=null) {
      model.addAttribute("qualitystation", airService.qualityModels(id));
      //TODO i tutaj jest błąd. id wali nullem. Gdzieś w HTML błąd, że c.getCityId() nie zostaje przypisane do idStation ;(
    }
//    model.addAttribute("qualitystation", airService.qualityModels(id));

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
