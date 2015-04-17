package example

import geb.Browser

/**
 * The Book Of Geb
 * 1.4.1 Inline Scripting
 *
 * http://www.gebish.org/manual/current/intro.html#full_examples
 */
Browser.drive {

    go "http://google.com/ncr"

    // make sure we actually got to the page
    assert title == "Google"

    // enter wikipedia into the search field
    $("input", name: "q").value("wikipedia")

    // wait for the change to results page to happen
    // (google updates the page dynamically without a new request)
    waitFor { title.endsWith("Google Search") }

    // is the first link to wikipedia?
    def firstLink = $("li.g", 0).find("a")
    assert firstLink.text() == "Wikipedia"

    // click the link 
    firstLink.click()

    // wait for Google's javascript to redirect to Wikipedia
    waitFor { title == "Wikipedia" }

}.quit()
