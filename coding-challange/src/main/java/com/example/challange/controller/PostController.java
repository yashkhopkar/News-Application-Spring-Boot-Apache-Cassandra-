package com.example.challange.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.challange.model.Post;
import com.example.challange.repository.PostRepository;

@RestController
public class PostController {

	@Autowired
	private PostRepository repository;
	List<Post> posts;
	
	@PostConstruct
	public void savePost() {
		
		posts = new ArrayList<>();
		
		posts.add(new Post(1, "Brazil opens vast Amazon reserve to mining", "Brazil's government has abolished a vast national reserve in the Amazon to open up the area to mining.", "BBC", "Brazil, amazon", "4.12.2016", "4.12.2017"));
		posts.add(new Post(2, "Google will ask: 'Are you depressed?'", "People searching for â€œdepressionâ€ on Google will soon be prompted to take a questionnaire to assess if they may be suffering from the illness.", "Dave Lee", "Google, depression", "11.15.2016", "11.18.2016"));
		posts.add(new Post(3, "Wayne Rooney international retirement: How will history judge his England career?", "Wayne Rooney'sÂ retirement from international dutyÂ - announced after England's all-time record goalscorer had been told he had won a recall at 31 - closes ", "BBC Sport", "Rooney, England, Soccer", "4.12.2012", "6.19.2017"));
		posts.add(new Post(4, "US Open: Milos Raonic withdraws because of wrist injury", "World number 11 Milos Raonic is the latest high-profile player to pull out of the US Open, which starts on Monday.", "BBC Sports", "US Open, Tennis, Raonic", "3.2.2015", "3.5.2015"));
		posts.add(new Post(5, "Billionaires and big ag are joining venture investors to fund lab-grown meat", "Eighty-five years ago, Winston ChurchillÂ wrote an article forÂ Popular MechanicsÂ that predicted humans would soon be growing their meat rather than ", "TechCrunch", "Billionaires, Ventures", "8.7.2012", "8.7.2013"));
		posts.add(new Post(6, "Thanks to Amazon, Seattle is now Americaâ€™s biggest company town", "Amazonâ€™s extraordinary growth has turned Seattle into the biggest company town in America.", "Amazon", "Amazon, Seattle", "3.6.2011", "3.9.2016"));
		posts.add(new Post(7, "This is How Google willÂ Collapse", "Google made almost all its money from ads. It was a booming businessâ€Šâ€”â€Šuntil it wasnâ€™t. Hereâ€™s how things looked right before the most spectacular ", "Hackernoon", "Google, collapse", "7.2.2012", "6.8.2014"));
		posts.add(new Post(8, "Universities are broke. So letâ€™s cut the pointless admin and get back to teaching", "A\r\n" + 
				"s students have been celebrating their exam results, pundits from across the political spectrum have been commiserating the state of British universities. Andrew Adonis, an education minister during the Blair years, hasÂ excoriated universitiesÂ for offering costly courses while jacking up the pay of their senior leaders. Nick Timothy, Theresa Mayâ€™s ex-advisor, thinks UK universities are an unsustainable â€œPonzi schemeâ€. The universities minister, Jo Johnson, has written about the need to put further pressure on seats of higher learning so students getÂ good value for money.\r\n" + 
				"Behind the political point-scoring are more serious issues. The university sector has been growing for decades, but now that growth is going into reverse. The number of undergraduates applying to universities has fallen byÂ 4% this year. Although close to 50% of the population goes through higher education, only aboutÂ 20% of jobs require an undergraduate degree. OneÂ US studyÂ found that 46% of students showed no improvement in their cognitive skills during their time at university. In some courses, like business administration, studentsâ€™ capacity to think got worse for the first few years. And after they graduated, many struggled to find full-time work while being loaded down with debt. Nearly a quarter of graduates wereÂ living with their parentsÂ or relatives.\r\n" + 
				"", "Guardian", "Universities", "5.12.2015", "5.14.2015"));
		posts.add(new Post(9, "New and improved bike routing, with low stress options", "Bicyclists ride to commute, to exercise, for sport, for leisure. But no matter the reason, most cyclists will ride on the road at some point, and when they do, theyâ€™ll think about the safety and comfort of their route.\r\n" + 
				"Should you take a longer route to ride on a road with a dedicated cycling lane? Do you take a left turn to avoid those difficult hills? Different cyclists will make different choices, as the ideal route for one bicyclist may not be so ideal for another.\r\n" + 
				"Valhalla, the open-source routing engine that powersÂ Mapzen Turn-by-Turn, has always had customization parameters. While these includeÂ use_roadsÂ andÂ use_hills, setting these to zero didnâ€™t quite define what most would consider a â€œlow stressâ€ bike route. At least not until now!\r\n" + 
				"This summer, I and the Mapzen routing team enhanced Valhallaâ€™s bicycle costing system. Not only is overall routing improved, butÂ use_roadsÂ andÂ use_hillsare now much more versatile: when both of these parameters are set to 0, Valhalla generates a nice, â€œlow-stressâ€ biking route. As these parameters get closer to 1, it linearly increases to a more â€œprofessionalâ€ biking route.\r\n" + 
				"Along with this new update, our default bike settings have also changed â€”Â use_roadsÂ andÂ use_hillsÂ previously defaulted to 0.5, but now they default to 0.25. The default bike (and thus speed) has also been changed from a road bike to a hybrid bike, which is more suited for city riding.\r\n" + 
				"Technical Details\r\n" + 
				"The meat of this update is the added support for low-stress biking. Our original goal was to introduce a new â€œlow-stress bikeâ€ costing class derived from the regular bike costing class. However, after doing this, we realized that the algorithms of the newÂ LowStressBicycleCostÂ class were actually cleaner and easier to manage than our original bike costing algorithms. This inspried us to rewrite the old bike code to look like the new low-stress bike code. This way, theÂ use_roadsÂ andÂ use_hillsÂ parameters acted as variables that scale the costs of edges (i.e. road segments) with particular attributes in a way that provides low-stress biking at one end of the spectrum, and professional road biking on the other.\r\n" + 
				"When originally making theÂ LowStressBicycleCostÂ class, we made use of research byÂ Michael B. LowryÂ at the University of Idaho,Â Peter FurthÂ at Northeastern, and Tracy Hadden-Loh with theÂ Rails-to-Trails Conservancy. Their paper titledÂ â€œLow-Stress Neighborhood Bikeability Assessment to Prioritize Bicycle Infrastructureâ€Â provides a way to score a road based on how stressful it is to bike on. Here are the variables that are included in the score:\r\n" + 
				"", "Mapzen", "Bikes", "5.12.2015", "12.12.2016"));
		posts.add(new Post(10, "D as a Better C", "D was designed from the ground up to interface directly and easily to C, and to a lesser extent C++. This provides access to endless C libraries, the Standard C ", "D Lang", "D, C, languages", "10.10.2010", "11.11.2011"));
		posts.add(new Post(11, "Why I haven't jumped ship from Common Lisp to Racket (just yet)", "Matthias FelleisenÂ jestedÂ \"Why are you still using CL when Scrbl/Racket is so much better :-)\" ? My response was as follows:\r\n" + 
				"", "Live Journal", "Lisp, Racket", "6.20.2016.", "12.20.2016."));
		posts.add(new Post(12, "Exxon Duped Public Over Climate Concerns, Harvard Research Says", "Exxon Mobil Corp. spent the last 40 years undermining public concern over climate change, even as its own scientists determined man-made global warming was ", "Bloomberg", "Exxon", "3/3/2013", "4/4/2014"));
		posts.add(new Post(13, "Mathematicians Tame Rogue Waves, Illuminating Future of LED Lighting", "In the 1950s, Philip Anderson, a physicist at Bell Laboratories, discovered a strange phenomenon. In some situations where it seems as though waves should ", "Quanta Magazine", "Mathematicians, LED", "12.3.13", "11.2.14"));
		posts.add(new Post(14, "Write a hash table in C", "Hash tables are one of the most useful data structures. Their quick and scalable insert, search and delete make them relevant to a large number of computer ", "Github", "Hash tables, C", "12.12.12", "11.11.15"));
		posts.add(new Post(15, "Google unveils a new, cheaper networking option for cloud customers: the public internet", "Google Cloud Platform customers will have a new option when selecting the type of network used to deliver their traffic to their users: they can keep using Googleâ", "Geek Wire", "Google", "3.15.2016", "3.17.2017"));
		
		repository.saveAll(posts);
	}
	
	@GetMapping("/getAllPosts")
	public List<Post>getPosts(){
		return repository.findAll();
	}
	@GetMapping("/getPostById/{id}")
	public Post getPostById(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@RequestMapping(path = "updatePost/{id}/{title}/{description}/{author}/{tags}/{created}/{updated}", method = RequestMethod.GET)
	public Post updatePost(@PathVariable int id, @PathVariable String title, @PathVariable String description, @PathVariable String author, @PathVariable String tags, @PathVariable String created, @PathVariable String updated) {
	    //Post post;
		for(Post p : getPosts()) {
			if(p.getId() == id) {
				p.setDescription(description);
		    	p.setTitle(title);
		    	p.setAuthor(author);
		    	p.setTags(tags);
		    	p.setCreated_at(created);
		    	p.setUpdated_at(updated);
		    	//post = p;
		    	repository.save(p);
			}
		}
		return null;
	}
	
	@RequestMapping(path = "createPost/{id}/{title}/{description}/{author}/{tags}/{created}/{updated}", method = RequestMethod.GET)
	public void createPost(@PathVariable int id, @PathVariable String title, @PathVariable String description, @PathVariable String author, @PathVariable String tags, @PathVariable String created, @PathVariable String updated) {
	    Post post = new Post(id, title, description, author, tags, created, updated);
	     posts.add(post);
		 repository.save(post);
	}
	
	@RequestMapping(path = "deletePost/{id}", method = RequestMethod.GET)
	public void deletePost(@PathVariable int id) {
	    //Post post;
		for(Post p : getPosts()) {
			if(p.getId() == id) {
				posts.remove(p);
		    	repository.saveAll(posts);
			}
		}
	}
}
