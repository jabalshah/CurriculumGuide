<%@ include file="includes/header.jsp" %>
                <main class="content">
                    <dl class="tabs vertical" data-tab>
  <dd class="active">
      <a href="#panel1">Core Computer Science</a></dd>
  <dd><a href="#panel2">Outside Concentration</a></dd>
  <dd><a href="#panel3">Analytic</a></dd>
  <dd><a href="#panel4">Communication</a></dd>
    <dd><a href="#panel2">Programming</a></dd>
  <dd><a href="#panel3">Upper Division Computing</a></dd>
  <dd><a href="#panel4">CS Focus Area</a></dd>
    <dd><a href="#panel2">Capstone</a></dd>
</dl>
<div class="tabs-content">
  <div class="content active" id="panel1">
      <table>
          <tr><td>ITCS 2214 Data Structures</td></tr>
    <tr><td>ITCS 2215 Design and Analysis of Algorithms</td></tr>
    <tr><td>ITCS 3146 Operating Systems and Networks</td></tr>
    <tr><td>ITCS 3155 Software Engineering</td></tr>
    <tr><td>ITCS 3160 Database Design and Implementation</td></tr>
    <tr><td>ITCS 3181 Logic and Computer Systems</td></tr>
    <tr><td>ITCS 4102 Programming Languages</td></tr>
      </table>
  </div>
  <div class="content" id="panel2">
    <p>This is the second panel of the basic tab example. This is the second panel of the basic tab example.</p>
  </div>
  <div class="content" id="panel3">
    <p>This is the third panel of the basic tab example. This is the third panel of the basic tab example.</p>
  </div>
  <div class="content" id="panel4">
    <p>This is the fourth panel of the basic tab example. This is the fourth panel of the basic tab example.</p>
  </div>
    
</div>
                    
                    <ul class="small-block-grid-1 medium-block-grid-3">
  <li>
    <dl class="accordion" data-accordion="myAccordionGroup">
      <dd class="accordion-navigation">
        <a href="#panel1c">Core Computer Science</a>
        <div id="panel1c" class="content">
                <table>
          <tr><td>ITCS 2214</td><td>Data Structures</td></tr>
    <tr><td>ITCS 2215 Design and Analysis of Algorithms</td></tr>
    <tr><td>ITCS 3146 Operating Systems and Networks</td></tr>
    <tr><td>ITCS 3155 Software Engineering</td></tr>
    <tr><td>ITCS 3160 Database Design and Implementation</td></tr>
    <tr><td>ITCS 3181 Logic and Computer Systems</td></tr>
    <tr><td>ITCS 4102 Programming Languages</td></tr>
      </table>
        </div>
      </dd>
      <dd class="accordion-navigation">
        <a href="#panel2c">Accordion 2</a>
        <div id="panel2c" class="content">
          Panel 2. Lorem ipsum dolor
        </div>
      </dd>
      <dd class="accordion-navigation">
        <a href="#panel3c">Accordion 3</a>
        <div id="panel3c" class="content">
          Panel 3. Lorem ipsum dolor
        </div>
      </dd>
    </dl>
  </li>
  <li>
    <dl class="accordion" data-accordion="myAccordionGroup">
      <dd class="accordion-navigation">
        <a href="#panel4c">Accordion 4</a>
        <div id="panel4c" class="content">
          Panel 4. Lorem ipsum dolor
        </div>
      </dd>
      <dd class="accordion-navigation">
        <a href="#panel5c">Accordion 5</a>
        <div id="panel5c" class="content">
          Panel 5. Lorem ipsum dolor
        </div>
      </dd>
      <dd class="accordion-navigation">
        <a href="#panel6c">Accordion 6</a>
        <div id="panel6c" class="content">
          Panel 6. Lorem ipsum dolor
        </div>
      </dd>
    </dl>
  </li>
</ul>
                    
                    <dl class="accordion" data-accordion>
  <dd class="accordion-navigation">
    <a href="#panel1">Accordion 1</a>
    <div id="panel1" class="content active">
      <dl class="tabs" data-tab>
        <dd class="active"><a href="#panel2-1">Tab 1</a></dd>
        <dd><a href="#panel2-2">Tab 2</a></dd>
        <dd><a href="#panel2-3">Tab 3</a></dd>
        <dd><a href="#panel2-4">Tab 4</a></dd>
      </dl>
      <div class="tabs-content">
        <div class="content active" id="panel2-1">
          <p>First panel content goes here...</p>
        </div>
        <div class="content" id="panel2-2">
          <p>Second panel content goes here...</p>
        </div>
        <div class="content" id="panel2-3">
          <p>Third panel content goes here...</p>
        </div>
        <div class="content" id="panel2-4">
          <p>Fourth panel content goes here...</p>
        </div>
      </div>
    </div>
  </dd>
  <dd class="accordion-navigation">
    <a href="#panel2">Accordion 2</a>
    <div id="panel2" class="content">
      <table>
          <tr><td>ITCS 2214 Data Structures</td></tr>
    <tr><td>ITCS 2215 Design and Analysis of Algorithms</td></tr>
    <tr><td>ITCS 3146 Operating Systems and Networks</td></tr>
    <tr><td>ITCS 3155 Software Engineering</td></tr>
    <tr><td>ITCS 3160 Database Design and Implementation</td></tr>
    <tr><td>ITCS 3181 Logic and Computer Systems</td></tr>
    <tr><td>ITCS 4102 Programming Languages</td></tr>
      </table>
    </div>
  </dd>
  <dd class="accordion-navigation">
    <a href="#panel3">Accordion 3</a>
    <div id="panel3" class="content">
      Panel 3. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
    </div>
  </dd>
</dl>
                </main>
<%@ include file="includes/aside.jsp" %>
<%@ include file="includes/footer.jsp" %>