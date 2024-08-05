Write a short answer in README.md. In your README.md, write a short answer to the following questions:

Did you use the same type of route to update patient information as to update an employee's department?
Why did you choose the selected strategy?
What are the advantages and disadvantages of the strategies you chose for creating these routes?
What is the cost-benefit between using PUT and PATCH?



Here’s a brief solutions:

Did you use the same type of route to update patient information as to update an employee's department?

No, I used PUT for updating patient information and PATCH for updating an employee's department.

Why did you choose the selected strategy?

I used PUT for patient information updates to allow complete replacement of patient details. PATCH was used for updating doctor's status and department to allow partial updates.

What are the advantages and disadvantages of the strategies you chose for creating these routes?

PUT ensures the entire resource is replaced, which is suitable for complete updates but can be inefficient for partial changes. PATCH is efficient for partial updates but requires handling of merging logic.

What is the cost-benefit between using PUT and PATCH?

PUT is straightforward for complete updates with less processing logic but more data transfer. PATCH is efficient for partial changes with less data transfer but requires complex logic to merge changes safely.