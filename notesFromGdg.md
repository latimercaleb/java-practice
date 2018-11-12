# Flutter Notes
- Think of Flutter as more of a UI layer to mobile apps that is cross platform. For hardware implementation it needs 3rd party components
- Udacity has a free course for learning Flutter: https://www.udacity.com/course/build-native-mobile-apps-with-flutter--ud905
- Plenty of fully working demo apps, reverse engineer them to learn the framework
- Animations on flutter should always lock on the device framerate by using vsync(this)
-  Animations use tween
- https://github.com/slightfoot/smooth_rotation
- https://github.com/ScottS2017/animations_workshop
- Flutter is binary exe that writes to an openGL texture
- Flutter is awesome, I need to deep dive and not be lazy about learning this shit

# Google A11y 101: Accessiblity
- A11y is an acronym for the accesibility
- Study of how ppl perceive and interact with things on the web
- 20% of all users have disabilities, even users that don't have disabilities can live in distracting environments
- There is alot of mobile users who don't have internet trying to use apps or websites
- Look into Blind v Target
- Deaf v Netflix
- Over 800 lawsuits are in place at the federal level for alledged accessible sites
- Diversabilities is thenew term, in 2010 google made a team to ensure their products
- Some products are Lookout, ChromeVox and google primer
- Section 508 is a federal law so government entities must have accessible sites

# Getting Started with FHIR
- Means for patients to get data from departments
- Fast healthcare interoperability resource
- OAuth2 + Rest api
- Henry Ford adopted FHIR,
- Currently an Open spec
- Allows us to build custom solutions around patient data
- fhir.cerner.com
- fhir.epic.com
- open.epic.com
- Implementation of a law from Obama about patient's being able to access their stuff
- EHR data
- Use case, remove insurance change or address change go between
- Authentication is a good thing

# Android animations
- Animations are engaging and using them
- github.com/davetrux/everyday-animation
- View, Prop, layout, physics, motionlayout
- A view aniation sets an XML file with properties and ties it to a view
- Prop animations are for pieces in a view and done only on actions
- Layout animes are for entire layouts and use scenes to determine
- Physics layouts are springs and flings and can be handled via flutter
- Motionlayout requires constraint views

## Kotlin is
- A statically typed lang that runs on JVM and it was made by the same folks that run jetbrains
- Oracle v Google lawsuit and it's dumb
- Kotlin is essentially open source java
- Kotlin is the second most language under javascript
- Evernote,robinhood and trello all use kotlin
- 3 styles: JVM, JS and Native
- Kotlin vs Flutter
- Kotlin can also be run in web assembly
- val is const, var is variable
- can use type inheritance var n:string = "foo"
- in order for something to be set to null it needs a ? var name :String? = "foo"
- Look into rxKotlin & Anko for libraries for Kotlin
- Kotlin testing framework? Spec
