using Microsoft.AspNetCore.Mvc;

namespace First.Controllers
{
    public class StudentController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
