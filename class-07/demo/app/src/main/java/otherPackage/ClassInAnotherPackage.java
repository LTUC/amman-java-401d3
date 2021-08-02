package otherPackage;


import demo.ParentClass;

public class ClassInAnotherPackage {

    // Create an instance of a class that is in a different package - this requires importing the package / class
    ParentClass parentClassInstanceInAnotherPackage = new ParentClass();

    public void accessTest(){
        // From outside a package, you can only access public fields and methods
        System.out.println(parentClassInstanceInAnotherPackage.publicIntInsideParent);
    }

}
