package com.imocc.springbootreadlist.controller;

import com.imocc.springbootreadlist.entity.Book;
import com.imocc.springbootreadlist.properties.AmazonPeoperties;
import com.imocc.springbootreadlist.repository.ReadingListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {
    private static final Logger logger = LoggerFactory.getLogger(ReadingListController.class);

    private AmazonPeoperties amazonPeoperties;
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, AmazonPeoperties amazonPeoperties) {
        this.amazonPeoperties = amazonPeoperties;
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readerBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> books = readingListRepository.findByReader(reader);
        if (books != null) {
            model.addAttribute("books", books);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonId", amazonPeoperties.getAssociateId());
        }
        logger.info("model={}", model.toString());
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList";
    }
}