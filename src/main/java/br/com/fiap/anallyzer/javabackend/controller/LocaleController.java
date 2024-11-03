package br.com.fiap.anallyzer.javabackend.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class LocaleController {

  @Autowired
  private LocaleResolver localeResolver;

  @GetMapping("/lang")
  public String changeLanguage(@RequestParam("lang") String lang, HttpServletRequest request,
      HttpServletResponse response) {
    Locale locale = new Locale(lang);
    localeResolver.setLocale(request, response, locale);
    return "Language changed to " + lang;
  }
}