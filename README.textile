h1. Target Platform Definition DSL and Generator


!https://ci.eclipse.org/cbi/buildStatus/icon?job=targetplatform-dsl/master!:https://ci.eclipse.org/cbi/job/targetplatform-dsl/

h2. Introduction

Target Platform Definition DSL and Generator provides a DSL with an advanced editor and a generator taking this DSL as input and generating a @.target@ file that PDE is able to read to provision a Target Platform.

The greatest thing about this tool is that it avoids you to manage the links to strict versions (e.g., @3.2.5.v20093493-sfoit-v-rrel@) in @.target@ files. It lets you define the bundles and features you want to use in your target platform and it handles the generation of the @.target@ file with the most recent available version. It is possible to restrict the lookup within a version range.

!https://www.eclipse.org/cbi/images/tpd/editor-outline.png(The targetplatform DSL editor)!

!https://www.eclipse.org/cbi/images/tpd/completion.png(Content assist example)!

h2. Installation

The update site "https://download.eclipse.org/cbi/updates/tpd/":https://download.eclipse.org/cbi/updates/tpd/ provides access to all versions going forward. The old update site for the 3.0.0-SNAPSHOT version at "https://download.eclipse.org/cbi/tpd/3.0.0-SNAPSHOT/":https://download.eclipse.org/cbi/tpd/3.0.0-SNAPSHOT/ is obselete.

h3. Requirements

* Java SE 8

* Eclipse 4.4+

* Xtext 2.11+

h2. Basic usage

* Create a file with @.tpd@ extension

* Once done, right-click on the file and select _Create Target Definition File_. You can also use the the keyboard shortcut @Alt + R@ (@⌥ Alt + R@ on Mac).

* To activate the target platform, you can either use the _Set as Target Platform_ action which is available on right-clicking on a @.tpd@ file, or use the @Ctrl + R@ (@⌘ Cmd + R@ on Mac) keybinding.

!https://www.eclipse.org/cbi/images/tpd/context-menu.png(The right-click command)!

* You can also right-click on an opened file and choose @Validate@, it will look for any error and will also check if all repositories are available and if all specified installation unit are available within the repository (and respecting the version range if any).

!https://www.eclipse.org/cbi/images/tpd/validate-action.png(The right-click validate command)!

!https://www.eclipse.org/cbi/images/tpd/validation-error.png(The validation result)!

h3. Syntax

An empty file is a valid file.

Strings can be surrounded by either simple quotes @'@ or double quotes @"@.

An ID is a character sequence starting with an alpha (no space allowed).

Keywords can be escaped by prefixing them with @^@.

You must start by defining the name of your target by specifying the header.

<pre>
target "The name of my target"
</pre>

Then you can optionally include other target platform files if you decided to split your target platform definition into several files. This will still lead to the generation of a single @.target@ file.

<pre>
include "base.tpd"
include "http://git.some.server.org/tree/tp/all.tpd"
</pre>

You can define some options about what should be retrieved from the p2 repository. You can do that with the @with@ keyword.

<pre>
with source allEnvironments	
</pre>

Available options are:

* @requirements@, whether this target must have all required IUs of the selected IUs available and included in the target to resolve successfully. If this option is true, the planner will be used to resolve otherwise the slicer is used. The planner can describe any missing requirements as errors.
* @allEnvironments@, whether this target should download and include environment (platform) specific units for all available platforms (vs. only the current target definition's environment settings).  Only supported  by the slicer so @requirements@ must not be used for this setting to be used.
* @source@, whether this location should download and include source bundles for the selected units if the associated source is available in the repository.
* @configurePhase@, whether this target should execute the configure phase after fetching the selected units.

bq. @source@ and @configurePhase@ are not supported by PDE before 3.8. If you use a version of PDE older than 3.8, these options will simply be ignored.

You can define the environment of your target platform about what should be retrieved from the p2 repository. You can do that with the @environment@ keyword. Content assist is your friend to find proper values.

<pre>
environment linux gtk x86_64
</pre>

Then, you define the locations of your p2 repositories. You can add as many locations as your want to your target. Location string must be URL, if your p2 repository is local, don't forget to put a @file:/@ URL.

<pre>
location "http://download.eclipse.org/releases/kepler/" 
</pre>

A location may have an ID that can be written before or after the URI. This is useful if you want to apply some maven stuff (providing a password, a mirror...) for this repository (see "#17":https://github.com/eclipse-cbi/targetplatform-dsl/issues/17 for examples).

<pre>
location kepler "http://download.eclipse.org/releases/kepler/" 
</pre>

Then, you may list the Installable Units (IUs) your want to include in your target. This can be _bundles_ or Eclipse _features_ (it may end with @feature.group@).

<pre>
location "http://download.eclipse.org/releases/kepler/" {	
    org.eclipse.emf.sdk.feature.group
}
</pre>

bq. Don't forget that you can escape a keyword by prefixing it with @^@, e.g. if you need to reference a bundle name @environment@, write it like @^environment@. The @^@ will be automatically stripped during the generation.

If no version is specified, the most recent IUs will be selected in the repository. You can restrain the range of version to use by using the same syntax as in @MANIFEST.MF@ files.

<pre>
location "http://download.eclipse.org/releases/juno/" {
    // select the most recent version of EMF after 2.7.0
    org.eclipse.emf.sdk.feature.group 2.7.0
    // select the most recent eclipse.rcp feature within the given range 
    org.eclipse.rcp.feature.group [4.0.0,4.3.0)
}
</pre>

Then, the most recent version of the given IU within this range will be selected.

bq. You can use the special keyword @lazy@ as version to state that you don't want the generator to select the version to put in the @.target@ file. Instead, it puts @0.0.0@ which is interpreted by PDE during the resolution of the @.target@.

h3. Call the generator from the command line

This project provide an Eclipse application that you can launch from the command line. The ID of the application is @org.eclipse.cbi.targetplatform.tpd.converter@ and is provided by the plugin @org.eclipse.cbi.targetplatform@. You can use this app in shell scripts, ant or maven build. If you use Tycho, you may have a look at "this example pom.xml file":https://github.com/hmarchadour/fr.obeo.releng.targetplatform/blob/78e0d470f57bfd82ba6fe7e1c09bfeb2fdfb0180/fr.obeo.releng.targetplatform-parent/targetdefinitions/pom.xml

h2. Build

Do a @mvn clean package@ or @mvn clean verify@.

On macOS, you need to add @-Ptarget-default@ to the command line due to the silly Maven profile activation policy.

h2. Developing and Contributing

Contributions are always welcome! See "CONTRIBUTING.md":https://github.com/eclipse-cbi/targetplatform-dsl/blob/master/CONTRIBUTING.md for details.

h2. License

This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0 which accompanies this distribution, and is available at "https://www.eclipse.org/legal/epl-2.0/":https://www.eclipse.org/legal/epl-2.0/ 
