Feature: Book Delete
  To allow a ADMIN Delete DE BOOK.
  
  Scenario: Delete Book 
    Given a  book: title 'One good book', written by 'Anonymous', published in 14 March 2013
      And another book: title 'Some other book', written by 'Tim Tomson', published in 23 August 2014
      And another book: title 'How to cook a dino', written by 'Fred Flintstone', published in 01 January 2012
      And another book: title 'Test by Example - REAL', written by 'Valter Lobo', published in 30 August 2014
    When the ADMIN delete book whith title 'Test by Example - REAL'
    Then 3 books have been found
      And Book 1  have the title 'One good bookxx' 
      And Book 2  have the title 'Some other book'
      And Book 3  have the title 'How to cook a dino'
   
     

 
    
      
    