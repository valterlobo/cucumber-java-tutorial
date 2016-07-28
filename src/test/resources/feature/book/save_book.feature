Feature: Book search
  To allow a customer to find his favourite books quickly, the library must offer multiple ways to search for a book.
  
  Scenario: Search books by publication year
    Given a book with the title 'One good book', written by 'Anonymous', published in 14 March 2013
      And another book with the title 'Some other book', written by 'Tim Tomson', published in 23 August 2014
      And another book with the title 'How to cook a dino', written by 'Fred Flintstone', published in 01 January 2012
      And another book with the title 'Test by Example', written by 'Valter Lobo', published in 30 August 2014
    When the customer searches for books published between 2013 and 2014
    Then 3 books should have been found
      And Book 1 should have the title 'Test by Example' 
      And Book 2 should have the title 'Some other book'
      And Book 3 should have the title 'One good book' 

  Scenario: Search books by word key
    Given a book with the title 'One good book', written by 'Anonymous', published in 14 March 2013
      And another book with the title 'Some other test book', written by 'Tim Tomson', published in 23 August 2014
      And another book with the title 'How to cook a dino', written by 'Fred Flintstone', published in 01 January 2012
      And another book with the title 'Test by Example', written by 'Valter Lobo', published in 30 August 2014
    When the customer searches for books with word 'test'
     Then 2 books should have been found by user
      And Book 1 have the title 'Test by Example' 
      And Book 2 have the title 'Some other test book'

  Scenario: Search books by  author key
    Given a book with the title 'One good book', written by 'Anonymous', published in 14 March 2013
      And another book with the title 'Some other test book', written by 'Tim Tomson', published in 23 August 2014
      And another book with the title 'How to cook a dino', written by 'Fred Flintstone', published in 01 January 2012
      And another book with the title 'Test by Example', written by 'Valter Lobo', published in 30 August 2014
    When the customer searches for books with word 'Valter'
     Then 1 books should have been found by user
      And Book 1 have the title 'Test by Example' 
    
      
    