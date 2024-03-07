package com.example.tro.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
      public boolean validate(String regex,String input){
          Pattern pattern;
          Matcher matcher;
          pattern=Pattern.compile(regex);
          matcher=pattern.matcher(input);
          return matcher.matches();
      }

}
