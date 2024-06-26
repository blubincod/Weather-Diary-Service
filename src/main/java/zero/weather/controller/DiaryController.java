package zero.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zero.weather.domain.Diary;
import zero.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @ApiOperation("일기 텍스트와 날씨 API를 이용해서 일기 저장합니다.")
    @PostMapping("/create/diary")
    void createDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                     @ApiParam(value = "생성할 날짜", example = "2020-03-01") LocalDate date,
                     @RequestBody
                     @ApiParam(value = "생성할 텍스트", example = "생성할 텍스트입니다.") String text) {
        diaryService.createDiary(date, text);
    }

    @ApiOperation("선택한 날짜의 일기를 불러옵니다.")
    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                          @ApiParam(value = "조회할 날짜", example = "2020-03-01") LocalDate date) {
        return diaryService.readDiary(date);
    }

    @ApiOperation("선택한 기간의 일기를 불러옵니다.")
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                            @ApiParam(value = "조회할 기간의 첫번째날", example = "2020-03-01") LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                            @ApiParam(value = "조회할 기간의 마직막날", example = "2020-03-31") LocalDate endDate) {
        return diaryService.readDiaries(startDate, endDate);
    }

    @ApiOperation("선택한 날짜의 일기의 텍스트를 수정합니다.")
    @PutMapping("/update/diary")
    void updateDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                     @ApiParam(value = "수정할 날짜", example = "2020-03-01") LocalDate date,
                     @RequestBody
                     @ApiParam(value = "수정할 텍스트", example = "수정할 텍스트입니다.") String text) {
        diaryService.updateDiary(date, text);
    }

    @ApiOperation("선택한 날짜의 일기를 삭제합니다.")
    @DeleteMapping("/delete/diary")
    void deleteDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                     @ApiParam(value = "삭제할 날짜", example = "2020-03-01") LocalDate date) {
        diaryService.deleteDiary(date);
    }
}
