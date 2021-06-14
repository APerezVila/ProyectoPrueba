package com.cebem.aliciaProyect.Controllers;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.aliciaProyect.Models.SongModel;
import com.cebem.aliciaProyect.Services.SongDBService;
import com.cebem.aliciaProyect.Services.TranslateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MainController {
    
    @Autowired
    SongDBService sDbService;
    @Autowired
    TranslateService tService;

    @GetMapping("/contar/{sentence}")
    public String countVowCons(@PathVariable String sentence){
        char ch[] = sentence.toCharArray();
        Integer sum[] = new Integer[2];
        for(char cha:ch){
            if( (cha >= 'a' && cha <= 'z') || (cha >= 'A' && cha <= 'Z') ){
                if(cha=='a'||cha=='e'||cha=='i'||cha=='o'||cha=='u'){
                    sum[0] += 1;
                }else{
                    sum[1] += 1;
                }
            }
        }
        return sum.toString();
    }

    @PostMapping("/guarda")
    @ResponseBody
    public String saveSong(@RequestParam (name = "name") String name, @RequestParam (required = false, name = "duration") Integer duration){
        try {
            SongModel song = new SongModel();
            song.setName(name);
            song.setDuration(duration);
            sDbService.saveSong(song);
        } catch (Exception e) {
            return "Ha ocurrido un error al guardar la canción";
        }
            return "Se ha guardado la canción correctamente";
        
       
    }

    @GetMapping("/listar")
    public String listData() {
        return sDbService.getSongs().toString();
    }

    @GetMapping("/{sentence}")
    public String transformSentence(@PathVariable String sentence){
        char ch[]=sentence.toCharArray();
        for (int i = 0; i < ch.length; i++)
        {
            if (ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u')
            {
                ch[i]='$'; 
            }   
        }
        return ch.toString();
    }

   /* @GetMapping("/traduce/{sentence}")
    public String translateSentence(@PathVariable String sentence){
        String transSentence = tService.getTranslation(sentence);
        return transSentence;
    }*/
}
