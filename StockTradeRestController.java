package com.hackerrank.stocktrades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.repository.StockTradeRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trades")
public class StockTradeRestController {

    @Autowired
	private StockTradeRepository tradeService;
	
	@GetMapping
	
	private ResponseEntity<List<Trade>> allTrades() {
		 return tradeService.getAllTrades();
		
		
		
	}
	
	@PostMapping
	private ResponseEntity<String> addNewTrade(@RequestBody Trade trade) {
		return tradeService.createNewTrade(trade);
	}
	
	@GetMapping(value="/{id}")
	private ResponseEntity<Trade> getTradeById(@PathVariable(value="id") Long id){
		return tradeService.getById(id);
		
	}
	
	@GetMapping(value="/users/{UserId}")
	private ResponseEntity<List<Trade>> getTradeByUserId(@PathVariable(value="UserId") Long UserId ) {
		return tradeService.getTradeByUserId(UserId);
		
	}
	
	@GetMapping(value="/stocks/{stockSymbol}")
	private ResponseEntity<List<Trade>> getTradeBySymbol(@PathVariable(value = "stockSymbol") String symbol){
		return tradeService.getTradeByStockSymbol(symbol);
	}
	
	@GetMapping(value= "/users/{UserId}/stocks/{stockSymbol}")
	private ResponseEntity<List<Trade>> getTradeByUserIdAndSymbol(@PathVariable(value="UserId") Long id, @PathVariable(value="stockSymbol") String symbol){
		return tradeService.getTradeByIdAndSymbol(id,symbol);
		
	}

    @DeleteMapping(value="/{id}")
	private ResponseEntity<String> deletAllTrades() {
		 tradeService.eraseAllTrades();
		 return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}