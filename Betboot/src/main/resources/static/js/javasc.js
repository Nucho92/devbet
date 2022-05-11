(function ($) {

  $('#search-button').on('click', function (e) {
    if ($('#search-input-container').hasClass('hdn')) {
      e.preventDefault();
      $('#search-input-container').removeClass('hdn')
      return false;
    }
  });

  $('#hide-search-input-container').on('click', function (e) {
    e.preventDefault();
    $('#search-input-container').addClass('hdn')
    return false;
  });

})(jQuery);

let letterList = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];
let numberOfItems = 5;
let first = 0;
let actualPage = 1;
let maxPages = Math.ceil(letterList.length / numberOfItems);

showList();

function firstPage() {
  first = 0;
  actualPage = 1;
  showList();
}

function nextPage() {
  if (first + numberOfItems <= letterList.length) {
    first += numberOfItems;
    actualPage++;
    showList();
  }
}

function previous() {
  if (first - numberOfItems >= 0) {
    first -= numberOfItems;
    actualPage--;
    showList();
  }

}

function lastPage() {
  first = (maxPages * numberOfItems) - numberOfItems;
  actualPage = maxPages;
  showList();

}

function showList() {
  let tableList = '';
  for (let i = first; i < first + numberOfItems; i++) {
    if (i < letterList.length) {
      tableList +=
        <tr>
          <td>${letterList[i]}</td>
        </tr>

    }
  }


  document.getElementById('letterList').innerHTML = tableList;
  showPageInfo();
}
function showPageInfo() {
  document.getElementById('pageInfo').innerHTML =
    Page ${ actualPage } / $ {maxPages}

}