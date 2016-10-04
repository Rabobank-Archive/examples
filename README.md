# Examples of using the Scala Rules DSL and Engine

The sources in this project contain example calculations to demonstrate the usage of the DSL provided by
the Scala Rules project. Currently they provide a very simple calculation which is used in the development
of the Scala Rules Viewer. However, longer term plans include turning this repository into an exhaustive
set of feature demonstrations for the engine and the DSL.

## Structure

**`org.scalarules.example.ExampleGlossary`**

Any calculation built with Scala Rules requires a set of Facts, usually defined in what we call a Glossary.
This example shows how Facts can be defined using the `Glossary` base class. This base class provides a series
of methods to define facts of single values and List values.

These Facts can then be used in a calculation to define how one Fact is derived from others.

Note: if you like being hardcore, you can skip using the `Glossary` base class and just declare and create instances
of `SingularFact` and `ListFact` directly. This can sometimes be useful in testing when you don't feel the need for
an entire glossary.

**`org.scalarules.example.ExampleDerivation`**

This demonstrates the actual usage of the DSL to create rules. The current example uses the Dutch DSL, since the
English version is still in progress. Once the DSL has been translated, a translated example will follow.

Important to note are the **imports** at the top of the Example Derivation file:

```scala
import org.scalarules.dsl.nl.grammar._
import org.scalarules.finance.nl._

import org.scalarules.example.ExampleGlossary._
```

The first two enable the use of the Scala Rules DSL and the Finance DSL respectively. Since these DSLs use a lot of
implicits to convert between values and DSL-words, the blanket imports are absolutely necessary. If you get errors like
`> is not a value of SingularFact[T]`, you can be pretty sure you are missing one of these imports.

The third import allows you to use the Facts defined within the Glossary.

## Running the Example

The object `org.scalarules.example.running.Runner` contains a `main`-method which will run the `ExampleDerivation` two
times: the first run is normal and the second one is a debug run, which also outputs all the steps taken by the engine.

# Improving the Examples

If you find something amiss with these examples, or you feel something could use a little more explanation, feel free
to contribute. Either open a PR with your proposed changes, or log an issue on the project.
