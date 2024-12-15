document.addEventListener('DOMContentLoaded', function () {
    var addTaskHtml = `
        <div class="modal" id="addTaskModal" style="display: none;">
            <div class="modal-content" style="background: white; padding: 20px; border-radius: 5px; width: 300px; margin: auto; position: relative;">
                <span class="close" id="closeModal" style="position: absolute; top: 10px; right: 15px; cursor: pointer;">&times;</span>
                <form action="/add" method="post">
                    
                    <label for="name" class="form-label">Task Name:</label>
                    <input type="text" id="name" name="name" class="form-control" placeholder="Insert name..." required><br><br>

                    <label for="deadlineDate" class="form-label">Deadline Date:</label>
                    <input type="text" id="deadlineDate" name="deadlineDate" class="form-control" placeholder="Insert deadline..." required><br><br>

                    <label for="isCompleted" class="form-label">Completed:</label>
                    <select id="isCompleted" name="isCompleted" class="form-control">
                        <option value="true">Completed</option>
                        <option value="false">Not Completed</option>
                    </select><br><br>

                    <label for="details" class="form-label">Task Description:</label>
                    <textarea name="details" id="details" class="form-control" placeholder="Insert description..." rows="4" required></textarea><br><br>

                    <button type="submit" class="btn btn-success">ADD TASK</button>
                </form>
            </div>
        </div>
    `;

    document.getElementById('addTask').innerHTML = addTaskHtml;

    const modal = document.getElementById('addTaskModal');
    const openModalButton = document.getElementById('openAddTaskButton');
    const closeModalButton = document.getElementById('closeModal');

    openModalButton.addEventListener('click', function () {
        modal.style.display = 'block';
    });

    closeModalButton.addEventListener('click', function () {
        modal.style.display = 'none';
    });

    window.addEventListener('click', function (event) {
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    });
});
